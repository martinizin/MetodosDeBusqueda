public class BusquedaBinaria {
    public static int buscar(int[] array, int valor) {
        int inicio = 0; // Índice inicial del arreglo
        int fin = array.length - 1; //Índice final del arreglo

        while (inicio <= fin) { //Bucle siempre y cuando se cumpla la condición indicada
            int medio = inicio + (fin - inicio) / 2; //Calcula el punto medio del rango acutal

            if (array[medio] == valor) { //Compara el valor calculado en medio con el que se está buscando
                return medio; //Envia el indice que es el valor encontrado
            } else if (array[medio] < valor) {
                inicio = medio + 1; //Sigue buscando hacia la mitad derecha
            } else {
                fin = medio - 1;//Busca en la mitad de la izquierda
            }
        }
        return -1; //Si el valor no se encuentra se retorna -1
    }
}

