// Класс исключения для проверки номера документа на содержание последовательности "abc"
class ABCSequenceException extends Exception {
    public ABCSequenceException(String message) {
        super(message);
    }
}

// Класс исключения для проверки номера документа на начало с последовательности "555"
class StartsWith555Exception extends Exception {
    public StartsWith555Exception(String message) {
        super(message);
    }
}

// Класс исключения для проверки номера документа на окончание последовательностью "1a2b"
class EndsOn1a2bException extends Exception {
    public EndsOn1a2bException(String message) {
        super(message);
    }
}

class Document {
    private String number;

    public Document(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

class DocumentProcessor {
    public static void processDocument(Document document) {
        try {
            validateDocumentNumber(document.getNumber());
            System.out.println("Документ с номером " + document.getNumber() + " прошел проверку.");
        } catch (ABCSequenceException | StartsWith555Exception | EndsOn1a2bException e) {
            System.out.println("Ошибка при обработке документа: " + e.getMessage());
        }
    }

    private static void validateDocumentNumber(String documentNumber) throws ABCSequenceException, StartsWith555Exception, EndsOn1a2bException {
        if (documentNumber.contains("abc")) {
            throw new ABCSequenceException("Номер документа содержит последовательность 'abc'.");
        }

        if (documentNumber.startsWith("555")) {
            throw new StartsWith555Exception("Номер документа начинается с последовательности '555'.");
        }

        if (documentNumber.endsWith("1a2b")) {
            throw new EndsOn1a2bException("Номер документа заканчивается последовательностью '1a2b'.");
        }
    }
}

// Пример использования
class Main {
    public static void main(String[] args) {
        Document validDocument = new Document("12345");
        Document invalidDocument1 = new Document("abc123");
        Document invalidDocument2 = new Document("555678");
        Document invalidDocument3 = new Document("9871a2b");

        DocumentProcessor.processDocument(validDocument);
        DocumentProcessor.processDocument(invalidDocument1);
        DocumentProcessor.processDocument(invalidDocument2);
        DocumentProcessor.processDocument(invalidDocument3);
    }
}