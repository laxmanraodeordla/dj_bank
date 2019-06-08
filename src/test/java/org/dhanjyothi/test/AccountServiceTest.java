
package org.dhanjyothi.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.util.DhanJyothiUtil;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private DhanJyothiUtil djUtil;

	private User user;
	private Account account;
	private Transaction transaction;

	@Before
	public void setup() {
		System.out.println(" Before method..");
		user = new User();
		account = new Account();
		transaction = new Transaction();
	}

	@Test
	public void test_getAccountDetails() throws Exception {
		System.out.println("GetAccountDetails method..");

		user.setFirstName("laxman");
		user.setLastName("rao");
		user.setAddressLine1("chn");
		user.setAddressLine2("sez");
		user.setAadharId("123412341234");
		user.setCity("chnn");
		user.setDob("10/06/1991");
		user.setEmailId("laxman@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPan("ASDFG1234J");
		user.setPin("600042");
		user.setState("tamilnadu");
		user.setUserName("laxman123");
		user.setPassword("Asdfasdf@1");
		// registerService.saveRegister(user);

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		Account acc = accountService.getAccountDetails(user.getUserId(), account.getAccountType());
		System.out.println("Account ::" + acc);

		Assert.assertEquals(account.getAccountBalance(), acc.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), acc.getAccountType());
		Assert.assertEquals(account.getAccountId(), acc.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), acc.getAccountCreatedDate());

		Assert.assertEquals(account.getUser().getUserId(), acc.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), acc.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), acc.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), acc.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), acc.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), acc.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), acc.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), acc.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), acc.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), acc.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), acc.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), acc.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), acc.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), acc.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), acc.getUser().getPassword());

		System.out.println("Object address not same :" + account + "=" + acc);
		Assert.assertNotSame(account.getUser(), acc.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void test_openSavingsAccount() throws Exception {
		System.out.println("OpenSavingsAccount method..");

		user.setFirstName("laxman");
		user.setLastName("rao");
		user.setAddressLine1("chn");
		user.setAddressLine2("sez");
		user.setAadharId("123412341234");
		user.setCity("chnn");
		user.setDob("10/06/1991");
		user.setEmailId("laxman@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPan("ASDFG1234J");
		user.setPin("600042");
		user.setState("tamilnadu");
		user.setUserName("laxman123");
		user.setPassword("Asdfasdf@1");
		// registerService.saveRegister(user);

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		accountService.openSavingsAccount(user);
		Account acc = accountService.checkAccountExists(account.getAccountId());

		System.out.println("Account ::" + acc);

		Assert.assertEquals(account.getAccountBalance(), acc.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), acc.getAccountType());
		Assert.assertEquals(account.getAccountId(), acc.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), acc.getAccountCreatedDate());

		Assert.assertEquals(account.getUser().getUserId(), acc.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), acc.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), acc.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), acc.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), acc.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), acc.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), acc.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), acc.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), acc.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), acc.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), acc.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), acc.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), acc.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), acc.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), acc.getUser().getPassword());

		System.out.println("Object address not same :" + account + "=" + acc);
		Assert.assertNotSame(account.getUser(), acc.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void test_openTermAccount() throws Exception {
		System.out.println("OpenTermAccount method..");

		user.setFirstName("laxman");
		user.setLastName("rao");
		user.setAddressLine1("chn");
		user.setAddressLine2("sez");
		user.setAadharId("123412341234");
		user.setCity("chnn");
		user.setDob("10/06/1991");
		user.setEmailId("laxman@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPan("ASDFG1234J");
		user.setPin("600042");
		user.setState("tamilnadu");
		user.setUserName("laxman123");
		user.setPassword("Asdfasdf@1");
		// registerService.saveRegister(user);

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(50000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());

		accountDao.openTermAccount(account);
		accountService.openTermAccount(account, user);
		List<Account> accountList = accountService.getTermAccountDetails(user.getUserId(), account.getAccountType());
		System.out.println("Account list ::" + accountList);

		for (Account acc : accountList) {
			System.out.println("Account ::" + acc);

			Assert.assertEquals(account.getDepositTenure(), acc.getDepositTenure());
			Assert.assertEquals(account.getMaturityAmount(), acc.getMaturityAmount());
			Assert.assertEquals(account.getAccountBalance(), acc.getAccountBalance());
			Assert.assertEquals(account.getAccountType(), acc.getAccountType());
			Assert.assertEquals(account.getAccountId(), acc.getAccountId());
			Assert.assertEquals(account.getAccountCreatedDate(), acc.getAccountCreatedDate());

			Assert.assertEquals(account.getUser().getUserId(), acc.getUser().getUserId());
			Assert.assertEquals(account.getUser().getFirstName(), acc.getUser().getFirstName());
			Assert.assertEquals(account.getUser().getLastName(), acc.getUser().getLastName());
			Assert.assertEquals(account.getUser().getDob(), acc.getUser().getDob());
			Assert.assertEquals(account.getUser().getEmailId(), acc.getUser().getEmailId());
			Assert.assertEquals(account.getUser().getAddressLine1(), acc.getUser().getAddressLine1());
			Assert.assertEquals(account.getUser().getAddressLine2(), acc.getUser().getAddressLine2());
			Assert.assertEquals(account.getUser().getCity(), acc.getUser().getCity());
			Assert.assertEquals(account.getUser().getState(), acc.getUser().getState());
			Assert.assertEquals(account.getUser().getAadharId(), acc.getUser().getAadharId());
			Assert.assertEquals(account.getUser().getMobileNumber(), acc.getUser().getMobileNumber());
			Assert.assertEquals(account.getUser().getPin(), acc.getUser().getPin());
			Assert.assertEquals(account.getUser().getPan(), acc.getUser().getPan());
			Assert.assertEquals(account.getUser().getUserName(), acc.getUser().getUserName());
			Assert.assertEquals(account.getUser().getPassword(), acc.getUser().getPassword());

			System.out.println("Object address not same :" + account + "=" + acc);
			Assert.assertNotSame(account.getUser(), acc.getUser());
			Assert.assertTrue("success", true);
		}

		Assert.assertEquals(1, accountList.size());

		List<Transaction> transactionList = accountService.loadAllTransactions(account.getAccountId());
		System.out.println("Transaction :" + transactionList);

		for (Transaction trans : transactionList) {

		}
		// Assert.assertEquals(1, transactionList.size());

	}

	@After
	public void teardown() {
		System.out.println(" After method..");

	}

}
