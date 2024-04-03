package dto;

public class AdminDTO {
	
	private String admin_id;
	private String admin_pwd;
	
	public AdminDTO() {
		
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	@Override
	public String toString() {
		return "AdminDTO [admin_id=" + admin_id + ", admin_pwd=" + admin_pwd + "]";
	}
}
