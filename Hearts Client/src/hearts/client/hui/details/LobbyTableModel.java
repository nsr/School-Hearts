/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.client.hui.details;

import hearts.defs.state.LobbyTableInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * Model dla tabeli stołów w gui.
 * @author Michał Charmas
 */
public class LobbyTableModel extends AbstractTableModel{

    ArrayList<String> tables = new ArrayList<String>();
    HashMap<String, LobbyTableInfo> data = new HashMap<String, LobbyTableInfo>();
    String[] columns = {"Nazwa", "Właściciel", "Ilość graczy", "Stan"};

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        LobbyTableInfo info = data.get(tables.get(rowIndex));
        switch(columnIndex) {
            case 0:
                return info.getTableName();
            case 1:
                return info.getOwner();
            case 2:
                return info.getPlayerCount();
            default:
                return info.getGameMode();
        }        
    }

    /**
     * Aktualizuje informacje o danym stole.
     * Jeżeli stół został usunięty usuwa go z modelu.
     * Zmusza tabelę do odświeżenia.
     * @param info
     */
    public void update(LobbyTableInfo info) {
        if(info.isRemoved()) {
            tables.remove(info.getTableName());
            data.remove(info.getTableName());
        } else {
            if(tables.contains(info.getTableName())) {
                data.remove(info.getTableName());
                data.put(info.getTableName(), info);
            } else {
                tables.add(info.getTableName());
                data.put(info.getTableName(), info);
            }
        }
        Collections.sort(tables);
        fireTableDataChanged();
    }

    /**
     * Zwraca szczegółowe informacje o danym stole.
     * @param x - który stół z tabeli
     * @return
     */
    public LobbyTableInfo getInfo(int x) {
        return data.get(tables.get(x));
    }
}
