package com.okaara.framework.repository;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * This class set a <a href="http://freemarker.org/">FreeMarker</a> template for
 * SQL.
 *
 */
public final class SqlTemplateUtils {

	private static final Logger logger = LoggerFactory.getLogger(SqlTemplateUtils.class);

	private final static Map<Class<?>, Configuration> configs = new HashMap<Class<?>, Configuration>();

	/**
	 * Given the object's class, the template will search for .sql files inside
	 * the sql folder, match-up its name with the arg and pre-process based on
	 * the parameters' {@link Map.Entry}.
	 * 
	 * @param baseClass
	 *            - the root for {@link ClassLoader} lookup for sql folder.
	 * @param file
	 *            - the searched file name.
	 * @param params
	 *            - the {@link Map} with the data to fulfill the template file.
	 * @return {@link String} with the expected SQL instruction.
	 */
	public static String parseFile(Class<?> baseClass, String file) {
		try {
			Configuration cfg = configs.get(baseClass);

			if (cfg == null) {
				cfg = new Configuration();
				cfg.setClassForTemplateLoading(baseClass, "sql");
				cfg.setLocalizedLookup(false);
				cfg.setObjectWrapper(new DefaultObjectWrapper());
				configs.put(baseClass, cfg);
			}
			
			// TODO set the encoding by parameter
			Template t = cfg.getTemplate(file, "UTF-8");

			StringWriter writer = new StringWriter();
			t.process(Model.create(), writer);
			writer.flush();
			writer.close();
			return writer.toString();
		} catch (FileNotFoundException e) {
			logger.debug("Não foi encontrado o arquivo \"" + file + "\"");
			throw new RuntimeException(e);
		} catch (Exception e) {
			/*
			 * Testar os tipos de exceções lançadas, dessa forma esta muito
			 * genérico. Fabrício.
			 */
			logger.debug("Erro ao analisar arquivo \"" + file + "\"");
			throw new RuntimeException(e);
		}
	}
}
