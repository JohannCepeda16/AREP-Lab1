class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            identifier: "",
            dates: [],
            values: [],
            loading: false
        }

        this.handleInput = this.handleInput.bind(this);
        this.searchActions = this.searchActions.bind(this);
    }

    handleInput(e) {
        this.setState({ ...this.state, identifier: e.target.value.toUpperCase() })
    }

    searchActions() {
        this.setState({ ...this.state, loading: true })
        fetch("/fetchActionByIdentifier?identifier=" + this.state.identifier, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(res => {
                if (res.status == "200") {
                    res.json()
                        .then(data => {
                            this.setState({
                                ...this.state,
                                dates: Object.keys(data["Time Series (Daily)"]),
                                values: Object.values(data["Time Series (Daily)"])
                            });
                            console.log(Object.values(data["Time Series (Daily)"]));
                        })
                        .catch(error => console.log(error));
                }
            })
            .catch(error => console.log(error))
            .finally(() => this.setState({ ...this.state, loading: false }))
    }

    render() {
        return (
            <div style={{ minHeight: "100vh", height: "auto", alignItems: "center" }} className="bg-dark my-auto">
                <h1 className="text-light text-center">Banco de acciones</h1>
                <input
                    placeholder="MSFT"
                    onChange={(e) => this.handleInput(e)}
                    value={this.state.identifier || ""}
                    className="form-control mx-auto text-center mt-3"
                    style={{ width: "30%" }}
                />
                {
                    !this.state.loading ?
                        <button
                            className="d-block mx-auto mt-3 btn btn-primary btn-block"
                            style={{
                                width: "30%"
                            }}
                            onClick={() => this.searchActions()}
                        >
                            Buscar
                        </button>
                        :
                        <div className="mx-auto bg-primary d-block spinner-border" role="status"></div>
                }
                <div className="mt-5 row mx-auto">
                    {
                        this.state.dates.map((item, i) => (
                            <div key={i} className="col-3 mx-auto">
                                <h6 className="text-success tex-center">{item}</h6>
                                <p className="text-light tex-center">{"Open: " + this.state.values[i]["1. open"]}</p>
                                <p className="text-light tex-center">{"High: " + this.state.values[i]["2. high"]}</p>
                                <p className="text-light tex-center">{"Low: " + this.state.values[i]["3. low"]}</p>
                                <p className="text-light tex-center">{"Close: " + this.state.values[i]["4. close"]}</p>
                                <p className="text-light tex-center">{"Volume: " + this.state.values[i]["5. volume"]}</p>
                            </div>
                        ))
                    }
                </div>
            </div>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById("root")
)