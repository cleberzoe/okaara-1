package com.okaara.client.framework.components.datatables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.fusesource.restygwt.client.JsonCallback;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.Resource;
import org.gwtbootstrap3.client.ui.constants.TableType;
import org.gwtbootstrap3.extras.bootbox.client.Bootbox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.okaara.client.framework.components.datatables.html.Cell;
import com.okaara.client.framework.components.datatables.html.TBody;
import com.okaara.client.framework.components.datatables.html.THead;
import com.okaara.client.framework.components.datatables.html.Tr;

public class DataTables extends ComplexPanel implements HasWidgets {

	private Tr heads;
	private TBody body;
	private THead head;
	private String source;
	private List<Widget> metadata = new ArrayList<>();
	private String tableID = Document.get().createUniqueId();
	private boolean initialized;

	public DataTables() {
		setElement(Document.get().createTableElement());
		addStyleName(TableType.DEFAULT.getCssName());
		getElement().setId(tableID);
		initComponents();
	}

	private void initComponents() {
		heads = new Tr();
		head = new THead();
		head.add(heads);
		super.add(head, (Element) getElement());

		body = new TBody();
		super.add(body, (Element) getElement());
	}

	@Override
	public void add(Widget w) {

		if (!(w instanceof TableColumn)) {
			throw new IllegalArgumentException("Only DataTableColumn can be inside a DataTables.");
		}

		metadata.add(w);
		setHead((TableColumn) w);
	}

	private void setHead(TableColumn column) {
		getHeads().add(Cell.createTH(column.getHeader()));
	}

	@Override
	public void clear() {
		body.clear();
	}

	@Override
	public Iterator<Widget> iterator() {
		return head.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return head.remove(w);
	}

	private void addToDataGrid(TableType tableType) {
		addStyleName(tableType.getCssName());
	}

	private void removeFromDataGrid(TableType tableType) {
		removeStyleName(tableType.getCssName());
	}

	public void setStriped(final boolean striped) {
		if (striped) {
			addToDataGrid(TableType.STRIPED);
		} else {
			removeFromDataGrid(TableType.STRIPED);
		}
	}

	public void setBordered(final boolean bordered) {
		if (bordered) {
			addToDataGrid(TableType.BORDERED);
		} else {
			removeFromDataGrid(TableType.BORDERED);
		}
	}

	public void setCondensed(final boolean condensed) {
		if (condensed) {
			addToDataGrid(TableType.CONDENSED);
		} else {
			removeFromDataGrid(TableType.CONDENSED);
		}
	}

	public void setHover(final boolean hover) {
		if (hover) {
			addToDataGrid(TableType.HOVER);
		} else {
			removeFromDataGrid(TableType.HOVER);
		}
	}

	public Tr getHeads() {
		return heads;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	protected void onLoad() {
		clear();
		Resource resource = new Resource(GWT.getHostPageBaseURL() + "services/" + getSource());
		Method method = new Method(resource, "GET");
		method.send(new JsonCallback() {

			@Override
			public void onSuccess(Method method, JSONValue response) {
				JSONArray array = response.isObject().get("list").isArray();
				setDataProvide(array);
				initTable();
			}

			@Override
			public void onFailure(Method method, Throwable exception) {
				Bootbox.alert("Erro: " + exception.getMessage());
			}
		});
	}
	
	@Override
	protected void onUnload() {
		clear();
	}

	private void setDataProvide(JSONArray array) {
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.get(i).isObject();

			if (jsonObject != null) {
				Tr tr = new Tr();
				for (Widget widget : metadata) {
					TableColumn column = (TableColumn) widget;
					if (jsonObject.containsKey(column.getKeyValue())) {
						String text = column.format(jsonObject);
						tr.add(Cell.createTD(text));
					}
				}
				addRow(tr);
			}
		}
	}

	private void addRow(Tr tr) {
		body.add(tr);
	}

	private void initTable() {
		if (!initialized) {
			initTable(tableID);
			initialized = true;
		}
	};

	private native void initTable(String id) /*-{
		
		var oTable = $wnd.$('#' + id).dataTable({
			"sDom" : "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>",
			"iDisplayLength" : 10,
			"language" : {
				"search" : "",
				"sLengthMenu" : "_MENU_",
				"oPaginate" : {
					"sPrevious" : "Anterior",
					"sNext" : "Próximo"
				},
				"sInfo" : "Exibindo _START_ a _END_ de _TOTAL_ registros",
				"sInfoEmpty" : "Não há registros para exibir",
				"sZeroRecords" : "Não há registros para exibir",
				"sLoadingRecords" : "aguarde..."
			}
		});
	}-*/;
}
