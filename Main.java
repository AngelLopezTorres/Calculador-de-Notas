public class Main{
    
    static HashMap<String, ArrayList<Double>> alumnos = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        System.out.println("Bienvenidos al Calculador de Notas");
        while (opcion != 4) {
            System.out.println("\nOpciones:");
            System.out.println("1. Añadir nota a un alumno");
            System.out.println("2. Calcular media");
            System.out.println("3. Mostrar resultado");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarNota(sc);
                    break;
                case 2:
                    calcularMedia(sc);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }

    public static void agregarNota(Scanner sc) {
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce la nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();

        alumnos.putIfAbsent(nombre, new ArrayList<>());
        alumnos.get(nombre).add(nota);

        System.out.println("Nota añadida correctamente.");
    }

    public static void calcularMedia(Scanner sc) {
        System.out.println("1. Media de un alumno");
        System.out.println("2. Media de todos");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            System.out.print("Nombre del alumno: ");
            String nombre = sc.nextLine();

            if (!alumnos.containsKey(nombre)) {
                System.out.println("Alumno no encontrado.");
                return;
            }

            ArrayList<Double> notas = alumnos.get(nombre);
            double suma = 0;

            for (double n : notas) {
                suma += n;
            }

            System.out.println("Media de " + nombre + ": " + (suma / notas.size()));
        } else if (opcion == 2) {
            double suma = 0;
            int total = 0;

            for (ArrayList<Double> notas : alumnos.values()) {
                for (double n : notas) {
                    suma += n;
                    total++;
                }
            }

            if (total == 0) {
                System.out.println("No hay notas.");
            } else {
                System.out.println("Media general: " + (suma / total));
            }
        }
    }
}