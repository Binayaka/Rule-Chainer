package com.binayaka.future;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a default implementation of the Rule, setting only the default rules,
 * i.e., it is not using the results from previous rules
 * 
 * @author Binayaka
 * 
 * @param <K>
 *            the result type of the execution of this rule
 * @param <V>
 *            the result type , if any error occurs
 */
public abstract class AbstractRule<K, V> implements Rule<K, V> {
	private Callable<K> definationActual;
	private Callable<V> definationError;
	private Object lastRuleRes;

	public AbstractRule() {
		defineRule();
		onError();
	}

	@Override
	public void defineRule() {
		definationActual = new Callable<K>() {

			@Override
			public K call() throws Exception {
				K res = defineActualCallback();
				return res;
			}

		};
	}

	@Override
	public void onError() {
		definationError = new Callable<V>() {

			@Override
			public V call() throws Exception {
				V res = defineErrorCallback();
				return res;
			}

		};
	}

	public abstract K defineActualCallback();

	public abstract V defineErrorCallback();

	@Override
	public boolean useLastResultFromChain() {
		return false;
	}

	@Override
	public Object getLastResultFromChain() {
		return lastRuleRes;
	}

	@Override
	public void setLastRuleResult(Object t) {
		lastRuleRes = t;
	}

	@Override
	public void callError() {
		try {
			definationError.call();
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "Error while calling callError", e);
		}
	}

	@Override
	public Object run() throws Exception {
		try {
			return definationActual.call();
		} catch (Exception e) {
			throw new Exception("Error while calling rule " + this, e);
		}
	}

}
