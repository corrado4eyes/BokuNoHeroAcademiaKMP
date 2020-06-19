//
//  ViewController.swift
//  BokuNoHeroAcademiaMultiplatform
//
//  Created by Corrado Quattrocchi on 11/06/2020.
//  Copyright © 2020 Corrado Quattrocchi. All rights reserved.
//

import UIKit
import shared

class HomeViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    // MARK: View properties
    
    @IBOutlet weak var bnhaCharacterTableView: UITableView!
    
// MARK: Business Logic Properties
    
    private let cellIdentifier = "BNHACharacterCell"
    private let koiniOS = KoiniOS()
    lazy var animeCharacterModel: NativeAnimeCharacterModel = NativeAnimeCharacterModel(
        viewUpdate: { [weak self] characters in
            self?.viewUpdate(characters: characters)
        }, errorUpdate: { [weak self] errorMessage in
            self?.errorUpdate(error: errorMessage)
        }
    )
    var bnhaCharacters: [BNHACharacterResponse] = []

    
    // MARK: View Lifecycle
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configureTableView()
        
        syncDown()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        animeCharacterModel.getCharactersList()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        animeCharacterModel.onDestroy()
    }
    
    // MARK: Table View Methods
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return bnhaCharacters.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier, for: indexPath)
        if let bnhaCell = cell as? BNHACharacterCell {
            let character = bnhaCharacters[indexPath.row]
            bnhaCell.configure(character: character)
        }
        return cell
    }
    
    // MARK: State Methods
    
    private func viewUpdate(characters: [BNHACharacterResponse]) {
        bnhaCharacters = characters
        bnhaCharacterTableView.reloadData()
    }
    
    private func errorUpdate(error: String) {
        print(error)
    }
    
    // MARK: Private Methods
    
    private func configureTableView() {
        bnhaCharacterTableView.delegate = self
        bnhaCharacterTableView.dataSource = self
    }
    
    private func syncDown() {
        self.animeCharacterModel.syncDown()
    }

}

