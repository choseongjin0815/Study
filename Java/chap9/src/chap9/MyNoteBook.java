package chap9;

public class MyNoteBook extends NoteBook{
	@Override
	public void noteName() {
		System.out.println("나의 노트북 이름은 맥북입니다.");
	}
	
	@Override
	public void display() {
		System.out.println("NoteBook Display");
	}
}
