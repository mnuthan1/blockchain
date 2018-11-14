package com.vilma.blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

import com.vilma.util.HashUtil;

public class Block {

	public String hash;
	public String previousHash;
	private Map<String,Long> data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
    private int nonce;
	//Block Constructor.
	public Block(Map<String,Long> data, String previousHash)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.data = data;
		this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }
    
    public String calculateHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String calculatedhash = HashUtil.generateHash( 
                previousHash +
                Long.toString(timeStamp) +
                data.toString()
                );
        return calculatedhash;
    }

    public void mineBlock(int difficulty) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			this.nonce ++;
			this.hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
}