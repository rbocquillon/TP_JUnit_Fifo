package fr.imtld.ilog.sdl;

import java.util.ArrayList;

public class Fifo implements FifoQueue, FifoHead{
	
	private ArrayList<Object> file;
	private int indiceHead;

	public Fifo() {
		file = new ArrayList<Object>();
		indiceHead = 0;
	}
	
	@Override
	public int getSize() {
		return file.size()-(indiceHead);
	}

	@Override
	public void remove() {
		if(this.getSize()>0) {
			file.remove(indiceHead);
		}
	}

	@Override
	public Object getHead() {
		if(!file.isEmpty()) {
			return file.get(indiceHead);
		}
		else {
			return null;
		}
	}

	@Override
	public void save(Class<?> clsSig) {
		if(clsSig==null) {
			indiceHead=0;
		}
		else {
			if(this.getSize()>0) {
				while(clsSig.isInstance(getHead())) {
					indiceHead++;
				}
			}
		}
	}

	@Override
	public void save(int iSig) {
		if(file.contains(iSig)) {
			if(file.indexOf(iSig)>=indiceHead) {
			indiceHead = file.lastIndexOf(iSig)+1;
			}
		}
	}

	@Override
	public void add(Object oSig) {
		if(oSig!=null) {
			file.add(oSig);
		}
	}

	@Override
	public void add(int iKind) {
		file.add(iKind);
	}

}
