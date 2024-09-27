package chap10;

public interface BasicBbsIf {
	public abstract void bbsList(int pageSize, int pageNo);
	public abstract void regist(String[] arrInput);
	public abstract void view(int bbsIdx);
	public abstract void delete(int bbsIdx);
	
}
