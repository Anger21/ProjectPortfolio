using UnityEngine;
using System.Collections;
using UnityEngine.UI;


//Help from: https://www.youtube.com/watch?v=gzXtfsezXWo
//Help from: https://www.youtube.com/watch?v=4fYd6-RFp_M&t=782s

public class HealthTwo : MonoBehaviour {

    Animator anim;
    public Image Bar;
    public Image Sword;
    public Image Shield;
    public Image Heart;
    public Image Heart2;
    public Image Heart3;
    public int hearts = 3;
    public float health = 100;
    public float curHealth = 0;
    float percHealth = 0;
    public float healing = 25;
    public bool shielded = false;

    // Use this for initialization
    void Start()
    {
        curHealth = health;
        anim = GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {

    }

    public void TakeDamage(float damageFromOne)
    {
        //block incoming dmg
        if (shielded == true)
        {
            curHealth -= 0;
            shielded = false;
            Shield.fillAmount = 0;
        }

        //if shielded == false
        else
        {
            //when player has hearts, he takes damage
            if (hearts > 0)
            {
                curHealth -= damageFromOne;
                percHealth = curHealth / health;
                //sending percentage of health to the SetHealth function
                SetHealth(percHealth);


                //reduce his hearts when he lost all his curHealth
                if (curHealth <= 0)
                {
                    curHealth = health;
                    percHealth = curHealth / health;
                    SetHealth(percHealth);
                    hearts--;
                    if (hearts == 2)
                    {
                        Heart.fillAmount = 0;
                    }
                    if (hearts == 1)
                    {
                        Heart2.fillAmount = 0;
                    }
                    if (hearts == 0)
                    {
                        Heart3.fillAmount = 0;
                    }
                }
            }

            //implement death-function
            else if (hearts == 0)
            {
                anim.SetInteger("Base-Layer-State", 5);
                SetHealth(0.0f);
                gameObject.GetComponent<PlayerController2>().inputEnabled = false;
            }
        }



    }


    //here to animate the life that the play still has
    void SetHealth(float myHealth)
    {
        Bar.fillAmount = myHealth;
    }


    void OnTriggerEnter2D(Collider2D other)
    {
        //collecting items
        if (gameObject.CompareTag("PlayerTag"))
        {
            if (other.gameObject.CompareTag("Axe"))
            {
                other.gameObject.SetActive(false);
                gameObject.tag = "WeaponedPlayer";
                Sword.fillAmount = 1;
            }
            else if (other.gameObject.CompareTag("OverPower"))
            {
                other.gameObject.SetActive(false);
                gameObject.tag = "EnergeticPlayer";
                Sword.fillAmount = 1;
            }
            else if (other.gameObject.CompareTag("Lance"))
            {
                other.gameObject.SetActive(false);
                gameObject.tag = "RangedWeaPlayer";
                Sword.fillAmount = 1;
            }
        }

        //healing itself
        if (other.gameObject.CompareTag("Potion"))
        {
            other.gameObject.SetActive(false);
            curHealth += healing;
            percHealth = curHealth / health;
            SetHealth(percHealth);
        }

        //putting on shield
        if (other.gameObject.CompareTag("Shield"))
        {
            other.gameObject.SetActive(false);
            shielded = true;
            Shield.fillAmount = 1;
        }
    }
}
