package com.binayaka.future;

/**
 * The implementations of rule will be used to chain rules. Use type K to call
 * the actual implementation Use type V to call error method
 * 
 * @author Binayaka
 * 
 */
public interface Rule<K, V> {

	/**
	 * This will call the rule
	 */
	public void defineRule();

	/**
	 * This will be called if any error occurs/is thrown
	 * 
	 * @param call
	 */
	public void onError();

	/**
	 * This will tell the chain to supply the last result it obtained, to this
	 * rule
	 * 
	 * @return
	 */
	public boolean useLastResultFromChain();

	/**
	 * This will get the last result from the chain. Implementations can assume
	 * that it will have the required result, as the chain will break if any
	 * error has occurred previously. However, it is up to the implementators of
	 * the rule to properly define what their result is
	 * 
	 * @return
	 */
	public Object getLastResultFromChain();

	/**
	 * The chain will set this result, if required
	 * 
	 * @param t
	 */
	public void setLastRuleResult(Object t);

	/**
	 * The actual method that will run. This method should return the required
	 * result
	 * 
	 * @return
	 */
	public Object run() throws Exception;

	/**
	 * This will be used to call the error method
	 * 
	 */
	public void callError();

}
