package br.com.concurrency;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "Implementacao de Callable";
	}

}
