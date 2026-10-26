# Taller: Simulador de descuentos con quarkus

### 1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?

IoC se aplica al delegar por completo al contenedor la gestion del ciclo de vida los componentes (VentaService, DescuentoRegular, DescuentoVIP, Auditoria), no se usa el operador new para instanciar manualmente las clases.

Aplicamos la anotación @Inject sobre las dependencias aplicadas en VentaService y en Main, con esto estamos inyectando las dependencias a usar, unas por atributo y otra por constructor.

### 2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?

Nos permiten desambiguar multiples implementaciones de una misma interfaz, son necesarios porque cuando existen dos o más clases que implementan la misma interfaz quarkus necesita saber exactamente qué implementación usar.

### 3. ¿Cuál es la diferencia entre @ApplicationScoped y @Dependent?

@ApplicationScoped garantiza una única instancia compartida para todas las clases que la necesiten durante todo el tiempo de ejecución del sistema.
@Dependent crea una nueva instancia cada que se inyecta en un objeto y su ciclo de vida está atado estrictamente al objeto donde fue inyectado.

### 4. ¿Por qué las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?

Porque no almacenan información específica de una venta dentro de sus atributos de clase, al operar únicamente con los datos que reciben por parámetro en sus métodos, una sola instancia en memoria puede procesar múltiples transacciones de ventas sin riesgo de cruzar o perder datos.

### 5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de CalculadoraDescuento?

Fallaría al iniciar la aplicación y lanzaría una excepción AmbiguousResolutionException, esto sucede porque el contenedor encontraría dos implementaciones candidatas válidas en el contexto (DescuentoRegular y DescuentoVIP) para resolver la interfaz CalculadoraDescuento y no sabría cuál de las dos inyectar.


