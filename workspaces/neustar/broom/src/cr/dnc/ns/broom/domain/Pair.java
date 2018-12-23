package cr.dnc.ns.broom.domain;

import com.google.gson.annotations.SerializedName;

public class Pair {
	@SerializedName("category")
	private final Category key;
	@SerializedName("subCategory")
	private final String value;
	
	public Pair(final Category key, final String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Category getCategory() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Pair)) {
			return false;
		}
		final Pair other = (Pair) obj;
		return this.key.equals(other.key) && this.value.equals(other.value);
	}
	
	@Override
	public int hashCode() {
		return this.key.hashCode();
	}
}
