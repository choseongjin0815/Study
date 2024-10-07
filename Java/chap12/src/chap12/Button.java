package chap12;

public class Button {
	OnClickListner ocl;
	void setOnClickListner(OnClickListner ocl) {
		this.ocl = ocl;
	}
	interface OnClickListner {
		public abstract void onClick();
	}
	void onClick() {
		ocl.onClick();
	}
	
	
	
	
	
	
}
