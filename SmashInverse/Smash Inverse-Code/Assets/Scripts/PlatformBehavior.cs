using UnityEngine;
using System.Collections;

public class PlatformBehavior : MonoBehaviour {
    
    // Erst einmal auslassen, weil es unwichtig zurzeit ist (11.11.2016)
	// Update is called once per frame
	void Update ()
    {
            
	}

    void OnTriggerEnter2D(Collider2D other)
    {
        if(other.gameObject.tag == "PlayerTag")
        {
            other.isTrigger = true;
        }
    }

    void OnTriggerExit2D(Collider2D other)
    {
        if(other.gameObject.tag == "PlayerTag")
        {
            other.isTrigger = false;
        }
    }
}
