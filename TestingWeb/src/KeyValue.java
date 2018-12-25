
import com.ebay.xcelite.annotations.Column;
import com.ebay.xcelite.annotations.Row;

@Row(colsOrder = {"accountType", "transactionIndustryType", "holderType", "holderName", "accountNumber", "accountAccessory", "city",
				  "state", "zipCode", "customerAccountCode", "transactionCode", "amount", "accountId", "trackData", "street"})
public class KeyValue {
	@Column
	private String accountType;
	@Column
	private String transactionIndustryType;
	@Column
	private String holderType;
	@Column
	private String holderName;
	@Column
	private String accountNumber;
	@Column
	private String accountAccessory;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipCode;
	@Column
	private String customerAccountCode;
	@Column
	private String transactionCode;
	@Column
	private String amount;
	@Column
	private String accountId;
	@Column
	private String trackData;
	@Column
	private String street;

	
	public String getAccountType() {
		return "accountType=" + accountType;
	}
	
	public String getTransactionIndustryType(){
		return "transactionIndustryType=" + transactionIndustryType;
	}
	
	public String getHolderType() {
		return "holderType=" + holderType;
	}
	
	public String getAccountNumber() {
		return "accountNumber=" + accountNumber;
	}
	
	public String getAccountAccessory() {
		return "accountAccessory=" + accountAccessory;
	}
	
	public String getCity() {
		return "city=" + city;
	}
	
	public String getState() {
		return "state=" + state;
	}
	
	public String getZipCode() {
		return "zipCode=" + zipCode;
	}
	
	public String getCustomerAccountCode() {
		return "customerAccountCode=" + accountType;
	}
	
	public String getTransactionCode() {
		return "transactionCode=" + transactionCode;
	}
	
	public String getAmount() {
		return "amount=" + amount;
	}
	
	public String getAccountId() {
		return "accountId=" + accountId;
	}
	
	public String getTrackData() {
		return "trackData=" + trackData;
	}
	
	public String getHolderName() {
		return "holderName=" + holderName;
	}
	
	public String getStreet() {
		return "street=" + street;
	}
}
