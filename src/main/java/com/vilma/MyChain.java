package com.vilma;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vilma.blockchain.Block;

public class MyChain {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		List<Block> blockList = new ArrayList<Block>();
		int difficulty = 1;
        Map<String,Long> ledger = new HashMap<String,Long>();
        ledger.put("total",100l);
		Block genesis = new Block(ledger, "0");
		blockList.add(genesis);
		System.out.println("Hash for block 1 : " + genesis.hash);
		genesis.mineBlock(difficulty);
		ledger.put("addr1",10l);
		Block secondBlock = new Block(ledger,genesis.hash);
		blockList.add(secondBlock);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		secondBlock.mineBlock(difficulty);
		ledger.put("addr2",10l);
		Block thirdBlock = new Block(ledger,secondBlock.hash);
		blockList.add(thirdBlock);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
		
	}
}