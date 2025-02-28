public class ListFactory<T> {

    /**
     * Enumeración de los tipos de lista disponibles.
     */
    public enum ListType {
        SinglyLinkedList(1),
        DoublyLinkedList(2);

        private final int value;

        ListType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static ListType fromValue(int value) {
            for (ListType type : ListType.values()) {
                if (type.getValue() == value) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Valor no válido: " + value);
        }
    }

    /**
     * Método para crear una lista predeterminada
     * @return la lista creada
     */	
    public IStack<T> createList() {
        return new SinglyLinkedList<>();
    }

    /**
     * Método para crear una lista dependiendo del tipo
     * @param type
     * @return la lista creada
     */
    public IStack<T> createList(ListType type) {
        switch (type) {
            case SinglyLinkedList:
                return new SinglyLinkedList<>();
            case DoublyLinkedList:
                return new DoublyLinkedList<>();
            default:
                throw new IllegalArgumentException("Tipo de lista no soportado: " + type);
        }
    }
}