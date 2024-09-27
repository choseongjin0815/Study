package chap9;

public class RunComputer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeskTop desk = new DeskTop();
		desk.turnOn();
		desk.display();
		desk.typing();
		desk.turnOff();
		System.out.println("-------------------------------------------------------------");
		MyNoteBook mNote = new MyNoteBook();
		mNote.run();
//		mNote.turnOn();
//		mNote.display();
//		mNote.typing();
//		mNote.noteName();
//		mNote.turnOff();

	}

}
