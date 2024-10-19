public class Notes {

    // In cryptocurrencies. coin ownership is transferred on the blockchain as transactions,
    // participants have address which funds can be sent to and sent from
    // Basic wallets can just store the addresses, but most of the wallets have software
    // i.e. they are able to make new transactions on the blockchain

    // Public key is the transaction address while the private key is kept safe by the wallet owner in order to make and sign transactions.
    // Each transaction has :
    // 1. sender public key
    // 2. receiver public key
    // 3. value of the funds for transfer
    // 4. inputs -> references to previous transactions -> to prove that sender has enough funds for transfer
    // 5. outputs -> just for logging and future input use
    // 6. Cryptographic signature -> proves that the owner of the address is the one sending this transaction -> to prevent frauds
    //
    // Purpose of cryptographic signature:
    // 1. Allow only owner to spend their cryptocurrency
    // 2. Prevent third party tampering in the transactions(frauds)
    //
}
