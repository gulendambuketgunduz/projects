#!/usr/bin/env python3
from bitcoinrpc.authproxy import AuthServiceProxy
rpc_user = 'test'
rpc_password = 'test'
rpc_port = '18332'

rpc_connection = AuthServiceProxy("http://%s:%s@127.0.0.1:%s"%(rpc_user, rpc_password,rpc_port))
rpc_connection.generate(101)

address1=rpc_connection.getnewaddress()
address2=rpc_connection.getnewaddress()
address3=rpc_connection.getnewaddress()

print("address3", address3)

validate_Address_3 = rpc_connection.validateaddress(address3)
print("address3_validation", validate_Address_3)

address3_pubKey = validate_Address_3['pubkey']
print("Public Key", address3_pubKey)
print(type(address3_pubKey))

multiSig = rpc_connection.createmultisig(2,[address1,address2,address3_pubKey])


print("Multi Signature Address", multiSig)

print(type(multiSig))

multisig_output = multiSig['address']
multisig_redeem_script = multiSig['redeemScript']

transaction_id = rpc_connection.sendtoaddress(multisig_output ,10.0)
print("Send To Address",transaction_id)

get_raw_tx=rpc_connection.getrawtransaction(transaction_id ,1)
print("Get Raw Transaction",get_raw_tx)

vout = get_raw_tx['vout'][0]['n']
print("vout", vout)

script = get_raw_tx['vout'][0]['scriptPubKey']['hex']
print("script", script)

new_address=rpc_connection.getnewaddress()

new_tx_id = rpc_connection.createrawtransaction([{"txid":transaction_id,"vout":vout }],{new_address:9.998})
print("Raw Transaction", new_tx_id)

dumpPrivKey_1 = rpc_connection.dumpprivkey(address1)
print("DumpPrivKey", dumpPrivKey_1)
dumpPrivKey_3 = rpc_connection.dumpprivkey(address3)
print("DumpPrivKey1", dumpPrivKey_3)

partly_signed_transaction = rpc_connection.signrawtransaction(new_tx_id,[{"txid":transaction_id, "vout":vout, "scriptPubKey":script, "redeemScript":multisig_redeem_script}], [dumpPrivKey_1])
print("signed_transaction", partly_signed_transaction)

partly_signed_transaction_id=partly_signed_transaction['hex']

signed_transaction = rpc_connection.signrawtransaction(partly_signed_transaction_id, [{"txid":transaction_id, "vout":vout, "scriptPubKey":script, "redeemScript":multisig_redeem_script}], [dumpPrivKey_3])
print("signed_transaction", signed_transaction)

SIGNED_RAW_TX = signed_transaction['hex']
print(SIGNED_RAW_TX)

sended_transaction = rpc_connection.sendrawtransaction(SIGNED_RAW_TX)
print("sended", sended_transaction)

rpc_connection.generate(1)
