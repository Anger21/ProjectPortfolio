using UnityEngine;
using System.Collections;
using UnityEngine.UI;

//Help from: https://www.youtube.com/watch?v=gzXtfsezXWo

public class DamageTwo : MonoBehaviour {

    Animator anim;
    public Image Sword;
    public Image Shield;
    public int readyForAtk = 0;
    public float atkTime;
    public float damageHand;
    public float damageMelee;
    public float damageRangedLance;
    public float damageRangedOverPower;

    // Use this for initialization
    void Start()
    {
        anim = GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        atkTime -= Time.deltaTime;
        if (Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.D))
        {

            if (atkTime > 0.0f)
            {
                readyForAtk += 1;
            }
        }
        else if (atkTime <= 0.0f)
        {

            readyForAtk = 0;
            atkTime = 1.3f;

        }
    }

    //connects DamageTWo with HealthOne
    void OnTriggerEnter2D(Collider2D other)
    {
        //dealing damage
        if (atkTime > 0.0f)
        {
            if (Input.GetKey(KeyCode.A) && readyForAtk > 1 || Input.GetKey(KeyCode.D) && readyForAtk > 1)
            {

                if (gameObject.CompareTag("PlayerTag"))
                {
                    anim.SetInteger("Base-Layer-State", 6);
                    other.gameObject.GetComponent<HealthOne>().TakeDamage(damageHand);
                }
                else if (gameObject.CompareTag("WeaponedPlayer"))
                {
                    anim.SetInteger("Base-Layer-State", 8);
                    other.gameObject.GetComponent<HealthOne>().TakeDamage(damageMelee);

                    gameObject.tag = "PlayerTag";
                    Sword.fillAmount = 0;

                }
                else if (gameObject.CompareTag("EnergeticPlayer"))
                {
                    anim.SetInteger("Base-Layer-State", 3);
                    other.gameObject.GetComponent<HealthOne>().TakeDamage(damageRangedOverPower);

                    gameObject.tag = "PlayerTag";
                    Sword.fillAmount = 0;
                }
                else if (gameObject.CompareTag("RangedWeaPlayer"))
                {
                    anim.SetInteger("Base-Layer-State", 7);
                    other.gameObject.GetComponent<HealthOne>().TakeDamage(damageRangedLance);

                    gameObject.tag = "PlayerTag";
                    Sword.fillAmount = 0;
                }
                else
                {
                    anim.SetInteger("Base-Layer-State", 0);
                }

            }
        }
        else
        {
            anim.SetInteger("Base-Layer-State", 0);
        }
        
    }
}
