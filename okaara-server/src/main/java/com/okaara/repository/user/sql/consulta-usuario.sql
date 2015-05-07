SELECT idusuario, 
	   nome, 
	   senha,
	   email
  FROM usuario
 WHERE idusuario = :id