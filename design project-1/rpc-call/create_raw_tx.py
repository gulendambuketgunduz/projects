from bitcoinrpc.authproxy import AuthServiceProxy


#check bitcoin.conf

rpc_user = 'test'
rpc_password = 'test'
rpc_port = '18332'

rpc_connection = AuthServiceProxy("http://%s:%s@127.0.0.1:%s"%(rpc_user, rpc_password,rpc_port))
#rpc_connection.generate(101)

address_1 = rpc_connection.getnewaddress()
print("Address_1:           " ,address_1)
rpc_connection.setaccount(address_1,"Sender")


txid = rpc_connection.sendtoaddress(str(address_1), 10.00 )
print("Transaction Id:      ", txid)

listunspent = rpc_connection.listunspent(0)
print("List Unspent Txs:    ", listunspent)

vout = -1

for i in listunspent:
    if i['txid'] == txid:
        vout = i['vout']
        break

new_address = rpc_connection.getnewaddress()
print("New Address          :", new_address)

transaction = rpc_connection.createrawtransaction ([{"txid":txid,"vout":vout}], {new_address:"39.9999"})
print("Transaction          :", transaction)

signed_transaction = rpc_connection.signrawtransaction(transaction)
print("Signed Transaction    :", signed_transaction)

SIGNED_RAW_TX = signed_transaction['hex']
print("Hex of Signed Tx:    ", SIGNED_RAW_TX)

sended_transaction = rpc_connection.sendrawtransaction(SIGNED_RAW_TX)
print("Sended Tx:           ", sended_transaction)

rpc_connection.generate(1)
