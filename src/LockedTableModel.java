import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class LockedTableModel extends DefaultTableModel {
	public LockedTableModel(Object[][] tableData, Object[] colNames) {
		super(tableData, colNames);
	}
	public final boolean isCellEditable(int row, int column) {
		return false;
	}
}
