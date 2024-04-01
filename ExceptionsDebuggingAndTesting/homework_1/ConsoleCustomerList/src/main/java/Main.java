import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            try {
                if (tokens[0].equals("add")) {
                    logger.log(Level.INFO, "Customer added");
                    executor.addCustomer(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    logger.log(Level.INFO, "List customers");
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    logger.log(Level.INFO, "Remove customer");
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    logger.log(Level.INFO, "User request" + executor.getCount() + " customers");
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    logger.log(Level.INFO, helpText);
                    System.out.println(helpText);
                } else {
                    logger.log(Level.INFO, "User request" + command);
                    System.out.println(COMMAND_ERROR);
                }
            } catch (Exception e) {
                System.out.println(e);
                logger.log(Level.ERROR, e);
            }
        }
    }
}
