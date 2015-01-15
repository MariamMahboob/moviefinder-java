import javax.swing.table.DefaultTableModel;

// Overriding the default behavior of DefaultTableModel
@SuppressWarnings("serial")
public class LockedTableModel extends DefaultTableModel {
	public LockedTableModel(Object[][] tableData, Object[] colNames) {
		super(tableData, colNames);
	}
	// Making cell's locked, users will not be able to change the values.
	public final boolean isCellEditable(int row, int column) {
		return false;
	}
}
