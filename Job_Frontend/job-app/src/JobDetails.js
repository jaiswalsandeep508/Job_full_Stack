import axios from "axios";
import React, {useState} from "react";


const JobDetails =() => {
    const [job, setJob] = useState(null);
    const [jobId, setJobId] = useState("");
    const [error, setError] = useState("");

    const getJob = async (event) => {
        event.preventDefault(); // Prevent page reload
      
        try {
            console.log(jobId);
            const response = await axios.get(`/jobs/${jobId}`);
            setJob(response.data);
            setError("");
        } catch (err) {
            setJob(null);
            setError("Job not found");
        }
    };
    

    return (
        <div>
            <h2>Job Search</h2>
            <input type="number" placeholder="Enter Job ID" value={jobId} onChange={(e) => setJobId(e.target.value)}></input>
            <button onClick={getJob}>Fetch Job</button>

            {job ? (
                <div>
                    <h3>{job.title}</h3>
                    <p>{job.description}</p>
                    <p>Location: {job.location}</p>
                </div>
            ) : (
                error && <p style={{color: "red"}}>{error}</p>
            )}
        </div>
    )
};

export default JobDetails;