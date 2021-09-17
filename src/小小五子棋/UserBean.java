package 小小五子棋;
//用户类

import java.io.Serializable;
import java.net.InetAddress;
import java.sql.Time;

public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String name="游客";
	protected InetAddress host;
	private Time time;
	
	//上述三个属性的get、set方法
	public InetAddress getHost() {
		return host;
	}
	
	public void setHost(InetAddress host) {
		this.host=host;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setTime(Time time) {
		this.time=time;
	}
	
	public Time getTime() {
		return time;
	}
	//?
	public String toString() {
		return getName();
	}

}
