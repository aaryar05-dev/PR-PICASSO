package PR_MAIN;
import PR_VENTANAS.Inicio;

public class PRPICASSO {

    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
        System.out.println("Hola :)");
        System.out.println("when inicias un programa:");
        
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
    }
}
