import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * La clase GenerateInfoFiles se encarga de generar archivos de prueba
 * que simulan las ventas de vendedores y la información de productos.
 */
public class GenerateInfoFiles {
    private static final String[] NAMES = {"Juan", "Ana", "Pedro", "Maria", "Luis"};
    private static final String[] LAST_NAMES = {"Gomez", "Lopez", "Martinez", "Hernandez", "Garcia"};
    private static final String[] PRODUCTS = {"P001;Product1;10.0", "P002;Product2;20.0", "P003;Product3;30.0"};

    /**
     * Método principal que genera los archivos de información de vendedores y productos.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        try {
            createSalesManInfoFile(5);
            createProductsFile(3);
            for (int i = 1; i <= 5; i++) {
                createSalesMenFile(10, "Seller" + i, i);
            }
            System.out.println("Files generated successfully.");
        } catch (IOException e) {
            System.err.println("Error generating files: " + e.getMessage());
        }
    }

    /**
     * Crea un archivo de ventas para un vendedor específico.
     *
     * @param randomSalesCount Cantidad de ventas aleatorias a generar.
     * @param name Nombre del vendedor.
     * @param id ID del vendedor.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("sales_" + name + ".txt"));
        Random rand = new Random();
        for (int i = 0; i < randomSalesCount; i++) {
            String product = PRODUCTS[rand.nextInt(PRODUCTS.length)];
            writer.write("ProductID" + (i + 1) + ";" + (rand.nextInt(10) + 1) + ";\n");
        }
        writer.close();
    }

    /**
     * Crea un archivo con la información de los productos disponibles.
     *
     * @param productsCount Cantidad de productos a generar (no se utiliza en esta implementación).
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public static void createProductsFile(int productsCount) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"));
        for (String product : PRODUCTS) {
            writer.write(product + "\n");
        }
        writer.close();
    }

    /**
     * Crea un archivo de información de vendedores con nombres y apellidos aleatorios.
     *
     * @param salesmanCount Cantidad de vendedores a generar.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("salesmen.txt"));
        for (int i = 0; i < salesmanCount; i++) {
            String name = NAMES[i % NAMES.length];
            String lastName = LAST_NAMES[i % LAST_NAMES.length];
            writer.write("DNI;" + i + ";" + name + ";" + lastName + "\n");
        }
        writer.close();
    }
}
