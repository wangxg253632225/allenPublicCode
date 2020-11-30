package com.dongnaoedu.proxy2;

/**
 * 代理的对象，完成代理的任务，设置具体的代理，调用具体的代理方法等
 * 
 * @author allen
 *
 */
public class Proxy implements IProxy {
	
	// 代理对象需要控制的原对象
	private RealProxy realObject;

	public Proxy(RealProxy realObject) {
		this.realObject = realObject;
	}

	@Override
	public void buyTicket() {
		realObject.buyTicket();
	}
}
