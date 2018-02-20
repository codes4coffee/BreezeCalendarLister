import javax.swing.*;
import java.util.ArrayList;
import java.util.Map;

public class MainUI extends JFrame {
    public MainUI(ArrayList<Calendar> calInfo) {
        super("Breeze Calendar List");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnLabels = {"Calendar Name", "ID"};
        Object[][] tableData = new Object[calInfo.size()][calInfo.size()];
        for(int i = 0; i < calInfo.size(); i++){
            tableData[i][0] = calInfo.get(i).getCalName();
            tableData[i][1] = calInfo.get(i).getCalID();
        }
        JTable table = new JTable(tableData, columnLabels);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);
        setVisible(true);
    }
}
