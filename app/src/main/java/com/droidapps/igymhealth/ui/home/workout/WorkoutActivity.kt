package com.droidapps.igymhealth.ui.home.workout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droidapps.igymhealth.databinding.ActivityWorkoutBinding
import com.droidapps.igymhealth.helpers.api.WGERJSON
import com.droidapps.igymhealth.helpers.api.WorkoutAPI
import com.droidapps.igymhealth.helpers.api.wgerAPI
import com.droidapps.igymhealth.ui.home.workout.ui.pages.PhysicalAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val Tag = "WORKOUT_ACTIVITY"

class WorkoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutBinding
    private lateinit var ExerciseAdapter : PhysicalAdapter
    lateinit var exerciseList : List<WGERJSON>
    private lateinit var cyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        exerciseList = ArrayList()
//        setupRecyclerView()
        initRecycler()
    }
//        setupRecyclerView()

//        lifecycleScope.launchWhenCreated {
//            binding.gymBar.isVisible = true
//            val response = try {
//                RetroFitInstance.api.getWorkouts()
//            } catch(e: IOException) {
//                Log.e("ERROR", "IOException, you might not have internet connection")
//                Toast.makeText(this@WorkoutActivity, "IOException, maybe no internet?", Toast.LENGTH_SHORT)
//                    .show()
//                binding.gymBar.isVisible = false
//                return@launchWhenCreated
//            } catch (e: HttpException) {
//                Log.e("ERROR", "HttpException, unexpected response")
//                Toast.makeText(this@WorkoutActivity, "HttpException unexpected response", Toast.LENGTH_SHORT)
//                    .show()
//                binding.gymBar.isVisible = false
//                return@launchWhenCreated
//            }
//
//                if(response.isSuccessful && response.body() != null) {
//                    ExerciseAdapter.workouts = response.body().!!
//                } else {
//                    Log.e("ERROR", "Response not successful")
//                    Log.e("ERROR", response.toString())
//                    Toast.makeText(this@WorkoutActivity, "Response not successful", Toast.LENGTH_SHORT)
//                        .show()
//                }
//
//            binding.gymBar.isVisible = false
//        }

        private fun initRecycler(){
            //TODO: Either remove this method or pick a new one
            val retro = Retrofit.Builder()
                .baseUrl(wgerAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val retroInst = retro.create(WorkoutAPI::class.java)

            //FIXME Wants a suspend function not sure why!!!
            val call: Call<List<WGERJSON>?>? = retroInst.getWorkouts()

            call!!.enqueue(object : Callback<List<WGERJSON>?> {


                override fun onResponse(
                    call: Call<List<WGERJSON>?>,
                    response: Response<List<WGERJSON>?>
                ) {
                    if (response.isSuccessful) {
//                    binding.gymBar.isVisible = false
                        exerciseList = response.body()!!
                        Log.d("WORKOUT", response.body().toString())
                        //BUG: E/Fail: java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
                        //BUG: This has something to do with how am parsing it.
                        for (items in exerciseList){
                            Log.v("VERBOSE", items.results.toString())
                        }
//                        Log.d("NAME", exerciseList[3].results.get(2).name)
                        Log.d("Res", response.body().toString())
                    }

//                    setupRecyclerView()
                    binding.gymView.apply {


                        ExerciseAdapter = PhysicalAdapter(exerciseList)
                        adapter = ExerciseAdapter
                        layoutManager = LinearLayoutManager(this@WorkoutActivity)
                    }
//                ExerciseAdapter

                }


                override fun onFailure(call: Call<List<WGERJSON>?>, t: Throwable) {
                    Log.e("Fail", t.toString())
                    Toast.makeText(this@WorkoutActivity, "Failed To Fetch Data", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }



    private fun setupRecyclerView() = binding.gymView.apply{
        ExerciseAdapter = PhysicalAdapter(exerciseList)

        adapter = ExerciseAdapter
        layoutManager = LinearLayoutManager(this@WorkoutActivity)
    }
}