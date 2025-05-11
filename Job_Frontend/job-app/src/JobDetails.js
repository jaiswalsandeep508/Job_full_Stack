import axios from "axios";
import React, {useState} from "react";
import styled from "styled-components";

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f5f5f5;
`;

const Form = styled.form`
    background: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
    display: flex;
    flex-direction: column;
    width: 300px;
`;

const Input = styled.input`
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 16px;
`;

const Button = styled.button`
    background: #4CAF50;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background 0.3s ease;

    &:hover {
        background: #45a049;
    }
`;

const ErrorMessage = styled.p`
    color: red;
    font-size: 14px;
`;

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
        <Container>
        <Form onSubmit={getJob}>
            <h2>Find a Job</h2>
            <Input
                type="number"
                placeholder="Enter Job ID"
                value={jobId}
                onChange={(e) => setJobId(e.target.value)}
                required
            />
            <Button type="submit">Search</Button>
            {error && <ErrorMessage>{error}</ErrorMessage>}
        </Form>

        {job && (
            <div>
                <h3>{job.title}</h3>
                <p>{job.description}</p>
                <p>Location: {job.location}</p>
            </div>
        )}
    </Container>
    );
};

export default JobDetails;