import axios from "axios";
import { useEffect, useState } from "react";
function Tickets() {

    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        const getAllTickets = async () => {
            const response = await axios.get('http://localhost:8080/api/ticket');
            console.log(response.data)
            setTickets(response.data)
        }
        getAllTickets();
    }, [])
    return (
        <div className="mt-4">
            <p className="h4">All Customer Tickets <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-file-plus-fill" viewBox="0 0 16 16">
                <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2M8.5 6v1.5H10a.5.5 0 0 1 0 1H8.5V10a.5.5 0 0 1-1 0V8.5H6a.5.5 0 0 1 0-1h1.5V6a.5.5 0 0 1 1 0" />
            </svg></p>

            {
                tickets.map((t) => (
                    <div className="card mt-4" key={t.id}>
                        <div className="card-header">
                            Subject: {t.subject}    &nbsp;&nbsp;&nbsp; ID: {t.id}
                        </div>
                        <div className="card-body">
                            {t.description}
                            <br /><br />
                            <button className="btn btn-primary btn-sm">EDIT</button>
                            &nbsp;&nbsp;&nbsp;
                            <button className="btn btn-danger btn-sm">DELETE</button>

                        </div>

                    </div>
                ))
            }

        </div>
    )
}

export default Tickets;