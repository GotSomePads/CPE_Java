package Exercice3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class CheckersGameGUIData extends Observable implements Map 
{
	// attribute
	private Map<Object, Object> mapData;
	
	// Ctor
	public CheckersGameGUIData(){
		this.mapData = new HashMap<Object, Object>();
	}

	@Override
	public void clear() { this.mapData.clear(); }

	@Override
	public boolean containsKey(Object key) { return this.mapData.get(key) != null; }

	@Override
	public boolean containsValue(Object value) { return this.mapData.containsValue(value); }

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object key) { return this.mapData.get(key); }

	@Override
	public boolean isEmpty() { return this.mapData.isEmpty(); }

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object arg0, Object arg1) { return this.mapData.put(arg0, arg1); }

	@Override
	public void putAll(Map m) { this.mapData.putAll(m); }

	@Override
	public Object remove(Object o) { return this.mapData.remove(o); }

	@Override
	public int size() {
		setChanged();
		notifyObservers();
		return this.mapData.size();
	}

	@Override
	public Collection values() { return null; }

}
