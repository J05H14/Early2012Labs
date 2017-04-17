package lab3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AttackMonitor {

	private List<MonsterAttack> attacks = new ArrayList<MonsterAttack>();

	public void operator() {
		String[] choices = { "Quit", "Input Monster Info", "Show Attacks", "Remove Attack", "Save List" };

		int choice = 0;
		String name = null;
		String date = null;
		String place = null;
		int victims = 0;
		int id = 0;
		int remover;

		do {
			choice = JOptionPane.showOptionDialog(null, "OPERATOR OPTIONS", "Main Menu", 0,
					JOptionPane.QUESTION_MESSAGE, null, choices, "null");

			switch (choice) {

			case 0:
				break;
			case 1:
				id = Integer.parseInt(JOptionPane.showInputDialog("Monster ID Number:"));
				name = JOptionPane.showInputDialog("What is it's name?");
				date = JOptionPane.showInputDialog("When did " + name + " attack? (MM/DD/YYYY)");
				place = JOptionPane.showInputDialog("Where did " + name + " attack?");
				victims = Integer.parseInt(JOptionPane.showInputDialog("How many died from the attack?"));

				MonsterAttack newAtk = new MonsterAttack(id, date, name, place, victims);

				attacks.add(newAtk);
				break;
			case 2:
				if (!(attacks.isEmpty())) {
					for (int i = 0; i < attacks.size(); i++) {
						JOptionPane.showMessageDialog(null, attacks.get(i));
					}
				} else {
					JOptionPane.showMessageDialog(null, "We're safe!");
				}
				break;
			case 3:
				remover = Integer.parseInt(
						JOptionPane.showInputDialog("ENTER THE ID NO. OF THE ATTACK YOU WANT DELETED\n" + attacks));

				for (int i = 0; i < attacks.size(); i++) {
					if (remover == (attacks.get(i).getId())) {
						attacks.remove(i);
					}
				}
			case 4:
				listSaver();
				break;
			}

		} while (choice != 0);

	}

	public void listSaver() {
		File outFile = new File(JOptionPane.showInputDialog("Where is it going"));

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(outFile));

			for (int i = 0; i < attacks.size(); i++) {
				writer.write(attacks.get(i).getId() + "," + attacks.get(i).getName() + "," + attacks.get(i).date() + "," + attacks.get(i).getYear() + "," + attacks.get(i).getPlace() + "," + attacks.get(i).getVictims() + "," + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}