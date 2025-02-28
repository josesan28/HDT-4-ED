public class StackFactory<T> {

    /**
     * Enumeración de los tipos de stack disponibles.
     */
    public enum StackType {
        Array(1),
        Vector(2),
        List(3);

        private final int value;

        StackType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static StackType fromValue(int value) {
            for (StackType type : StackType.values()) {
                if (type.getValue() == value) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Valor no válido: " + value);
        }
    }

    /**
     * Método para crear un stack
     * @param type
     * @return el stack creado
     */
    public IStack<T> createStack(StackType type, ListFactory.ListType listType) {
        switch (type) {
            case Array:
                return new ArrayListStack<>();
            case Vector:
                return new VectorStack<>();
            case List:
                return new ListFactory<T>().createList(listType);
            default:
                throw new IllegalArgumentException("Tipo de stack no soportado: " + type);
        }
    }
}
