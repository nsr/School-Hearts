/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance.answers;

/**
 * Odpowiedź na utworzenie stołu.
 * Żeby zrozumieć zobacz JoinTableAnswer.
 * @author Michał Charmas
 */
public class CreateTableAnswer extends JoinTableAnswer {

    public CreateTableAnswer(String tableName, Boolean success) {
        super(tableName, success, 0);
    }

}
