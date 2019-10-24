# ScalaProject

AccountTests:

```bash
[info] AccountTests:
[info] - Test 01: Valid account withdrawal
[info] - Test 02: Invalid account withdrawal should throw exception
[info] - Test 03: Withdrawal of negative amount should throw exception
[info] - Test 04: Valid account deposit
[info] - Test 05: Deposit of negative amount should throw exception
[info] - Test 06: Correct balance amount after several withdrawals and deposits
[info] AccountTransferTests:
[info] - Test 07: Valid transfer between accounts
[info] - Test 08: Transfer of negative amount between accounts should fail
[info] - Test 09: Invalid transfer between accounts due to insufficient funds should lead to transaction status FAILED and no money should be transferred between accounts
[info] - Test 10: Correct balance amounts after several transfers
[info] - Test 11: Failed transactions should retry and potentially succeed with multiple allowed attempts
[info] - Test 12: Some transactions should be stopped with only one allowed attempt
[info] Run completed in 23 seconds, 781 milliseconds.
[info] Total number of tests run: 12
[info] Suites: completed 2, aborted 0
[info] Tests: succeeded 12, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 36 s, completed Oct 24, 2019, 2:50:30 PM
```

