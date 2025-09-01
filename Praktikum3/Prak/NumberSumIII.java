public class NumberSumIII {

    public Number[] numberSumIII(Number[] numbers) {
        Number[] result = new Number[numbers.length]; // array keluaran
        int index = 0;

        // buat sesuai dengan soal dan gunakan fungsi add, subtract, multiply untuk memudahkan
        boolean[] processed = new boolean[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (processed[i]) continue;
            
            processed[i] = true;
            Number current = numbers[i];
            
            int opIndex = 0; 
            
            for (int j = i + 1; j < numbers.length; j++) {
                if (!processed[j] && numbers[j].getClass().equals(numbers[i].getClass())) {
                    processed[j] = true;
                
                    if (opIndex == 0) {
                        current = add(current, numbers[j]);
                    } else if (opIndex == 1) {
                        current = subtract(current, numbers[j]);
                    } else if (opIndex == 2) {
                        current = multiply(current, numbers[j]);
                    }
                    
                    opIndex = (opIndex + 1) % 3;
                }
            }
            
            result[index++] = current;
        }
        
        // mengisi array result yang tersisa dengan null
        while (index < result.length) {
            result[index++] = null;
        }
        
        return result;
    } 

    private static Number add(Number a, Number b) { // lakukan operasi penjumlahan sesuai tipe data
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() + b.intValue();
        }
        else if (a instanceof Byte && b instanceof Byte) {
            return (byte)(a.byteValue() + b.byteValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        }
        else if (a instanceof Float && b instanceof Float) {
            return a.floatValue() + b.floatValue();
        }
        else if (a instanceof Short && b instanceof Short) {
            return (short)(a.shortValue() + b.shortValue());
        }
        else if (a instanceof Long && b instanceof Long) {
            return a.longValue() + b.longValue();
        }
        return null;
    }
     
    private static Number subtract(Number a, Number b) { // lakukan operasi pengurangan sesuai tipe data
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() - b.intValue();
        }
        else if (a instanceof Byte && b instanceof Byte) {
            return (byte)(a.byteValue() - b.byteValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        }
        else if (a instanceof Float && b instanceof Float) {
            return a.floatValue() - b.floatValue();
        }
        else if (a instanceof Short && b instanceof Short) {
            return (short)(a.shortValue() - b.shortValue());
        }
        else if (a instanceof Long && b instanceof Long) {
            return a.longValue() - b.longValue();
        }
        return null;
    } 

    private static Number multiply(Number a, Number b) { // lakukan operasi perkalian sesuai tipe data
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() * b.intValue();
        }
        else if (a instanceof Byte && b instanceof Byte) {
            return (byte)(a.byteValue() * b.byteValue());
        }
        else if (a instanceof Double && b instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        }
        else if (a instanceof Float && b instanceof Float) {
            return a.floatValue() * b.floatValue();
        }
        else if (a instanceof Short && b instanceof Short) {
            return (short)(a.shortValue() * b.shortValue());
        }
        else if (a instanceof Long && b instanceof Long) {
            return a.longValue() * b.longValue();
        }
        return null;
    } 
}
