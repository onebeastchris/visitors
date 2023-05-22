![modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_64h.png)
<img src="https://i.imgur.com/iaETp3c.png" alt="" width="200" >
![fabric-api](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/requires/fabric-api_64h.png)

## visitors
A fabric mod allowing non-whitelisted players to check out the server in spectator mode before applying. 

Modrinth: https://modrinth.com/mod/visitors

Features:
- allows players not on the whitelist to join in spectator mode
- when player is whitelisted, they should be able to start playing
- optional /discord command with clickable discord invite to apply in

Notes:
- requires FabricAPI
- restores spawn position & default gamemode once player is whitelisted
- whitelist needs to be on, otherwise, this wont work (and is probably unnecessary)
- banned players can't join, duh
- WIP: i intend to (at some point) add a adventure-mode-like visitor mode, so players can interact with other players while not being able to interact with the world

Currently supported versions: 1.19.3, 1.19.4
