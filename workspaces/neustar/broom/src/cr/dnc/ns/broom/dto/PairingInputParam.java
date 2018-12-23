package cr.dnc.ns.broom.dto;

import java.util.ArrayList;
import java.util.List;

import cr.dnc.ns.broom.domain.Pair;

public class PairingInputParam {
	private List<Pair> pairs;

	public List<Pair> getPairs() {
		return this.pairs;
	}

	public void setPairs(final List<Pair> pairs) {
		this.pairs = new ArrayList<>(pairs);
	}
}
