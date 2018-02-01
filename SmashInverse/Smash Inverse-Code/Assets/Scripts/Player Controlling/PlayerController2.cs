using UnityEngine;
using System.Collections;

//Help from: https://www.youtube.com/watch?v=Tpak3yIkS5M&t
//Help from: https://www.youtube.com/watch?v=38i4JQguH9s

public class PlayerController2 : MonoBehaviour
{
    
    public bool inputEnabled = true;

    //movement variables
    Animator anim;
    public float speed;
    public float jump;
    float moveVelocity;

    //isGrounded boolean
    bool isGrounded;
    /*bool doubleJumped;*/

    //for DoubleJump
    public Transform groundCheck;
    public float groundCheckRadius;
    public LayerMask whatIsGround;



    void Start()
    {
        anim = GetComponent<Animator>();
    }

    void FixedUpdate()
    {
        isGrounded = Physics2D.OverlapCircle(groundCheck.position, groundCheckRadius, whatIsGround);
    }


    // Update is called once per frame
    void Update()
    {
        if (isGrounded)
        {
            /*doubleJumped = false; */
        }


        //jumping function
        if (Input.GetKey(KeyCode.W) && inputEnabled == true)
        {
            if (isGrounded == true)
            {
                
                GetComponent<Rigidbody2D>().velocity = new Vector2(GetComponent<Rigidbody2D>().velocity.x, jump);

            }


            /*else if (isGrounded == false && doubleJumped == false)
            {
                anim.SetInteger("Base-Layer-State", 2);
                GetComponent<Rigidbody2D>().velocity = new Vector2(GetComponent<Rigidbody2D>().velocity.x, jump);
                doubleJumped = true;

            }*/


            else
            {
                anim.SetInteger("Base-Layer-State", 0);
            }

        }

        moveVelocity = 0;

        //2D Movement

        //LEFT
        if (Input.GetKey(KeyCode.A) && inputEnabled == true)
        {
            transform.localRotation = Quaternion.Euler(180, 180, 0);
            anim.SetInteger("Base-Layer-State", 1);
            moveVelocity = -speed;
        }
        else if (Input.anyKey == false)
        {
            anim.SetInteger("Base-Layer-State", 0);
        }
        else if (Input.GetKey(KeyCode.W) && Input.GetKey(KeyCode.A) && inputEnabled == true)
        {
            anim.SetInteger("Base-Layer-State", 2);
        }

        //RIGHT
        if (Input.GetKey(KeyCode.D) && inputEnabled == true)
        {
            transform.localRotation = Quaternion.Euler(180, 0, 0);
            anim.SetInteger("Base-Layer-State", 1);
            moveVelocity = speed;
        }
        else if (Input.anyKey == false)
        {
            anim.SetInteger("Base-Layer-State", 0);
        }
        else if (Input.GetKey(KeyCode.W) && Input.GetKey(KeyCode.D) && inputEnabled == true)
        {
            anim.SetInteger("Base-Layer-State", 2);
        }


        GetComponent<Rigidbody2D>().velocity = new Vector2(moveVelocity, GetComponent<Rigidbody2D>().velocity.y);

    }
}
