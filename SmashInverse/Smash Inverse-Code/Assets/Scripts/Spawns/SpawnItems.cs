using UnityEngine;
using System.Collections;

//Help from: https://www.youtube.com/watch?v=iLTP4EbM1N4&t

public class SpawnItems : MonoBehaviour {

    public Transform[] spawnPoints;
    public float spawnTime;

    public GameObject[] items;

	// Use this for initialization
	void Start () {

        //repeat Spawning
        InvokeRepeating("SpawnLogic", spawnTime, spawnTime);

	}
	
	// Update is called once per frame
	void Update () {
	
	}

    void SpawnLogic()
    {
        //randomize the place for the item
        int spawnIndex = Random.Range(0, spawnPoints.Length);

        //randomize the type of the item
        int itemIndex = Random.Range(0, items.Length);

        //spawn the item
        GameObject clone = (GameObject) Instantiate(items[itemIndex], spawnPoints[spawnIndex].position, spawnPoints[spawnIndex].rotation);
        Destroy(clone, 15);

    }
}
