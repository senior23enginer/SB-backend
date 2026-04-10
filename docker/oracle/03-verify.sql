WHENEVER SQLERROR EXIT SQL.SQLCODE

ALTER SESSION SET CONTAINER = FREEPDB1;

DECLARE
  v_count NUMBER;
BEGIN
  -- Validar que existe la tabla principal del esquema.
  SELECT COUNT(*)
    INTO v_count
    FROM user_tables
   WHERE table_name = 'DD_PEDIDO_PICKING';

  IF v_count = 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'No existe DD_PEDIDO_PICKING');
  END IF;
END;
/

DECLARE
  v_count NUMBER;
BEGIN
  -- Validar datos de prueba insertados en sql-seek.txt.
  SELECT COUNT(*)
    INTO v_count
    FROM dd_pedido_cliente;

  IF v_count < 2 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Faltan datos en DD_PEDIDO_CLIENTE');
  END IF;
END;
/

DECLARE
  v_count NUMBER;
BEGIN
  SELECT COUNT(*)
    INTO v_count
    FROM dd_pedido_picking;

  IF v_count < 2 THEN
    RAISE_APPLICATION_ERROR(-20003, 'Faltan datos en DD_PEDIDO_PICKING');
  END IF;
END;
/

PROMPT Verificacion SQL completada correctamente.
EXIT;
